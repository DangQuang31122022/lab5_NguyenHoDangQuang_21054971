package org.example.lab5_nguyenhodangquang_21054971.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import jakarta.servlet.http.HttpServletRequest;
import org.example.lab5_nguyenhodangquang_21054971.models.Customer;
import org.example.lab5_nguyenhodangquang_21054971.models.Order;
import org.example.lab5_nguyenhodangquang_21054971.models.Product;
import org.example.lab5_nguyenhodangquang_21054971.services.implement.CustomerService;
import org.example.lab5_nguyenhodangquang_21054971.services.implement.OrderService;
import org.example.lab5_nguyenhodangquang_21054971.services.implement.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;

@Controller
@RequestMapping("/order-product")
public class OrderController {
    @Autowired
    private OrderService os;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private ProductService productService;
    @Autowired
    private JmsTemplate template;
    private Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ").create();

    @GetMapping("/")
    public String directToIndex() {
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("products", productService.findAll());
        return "index";
    }

    @PostMapping("/order")
    public ModelAndView makeOrder(HttpServletRequest request) throws Exception {
        ModelAndView mav = new ModelAndView("index");
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String productID = request.getParameter("product");
        String quantity = request.getParameter("quantity");

        // Check if customer exists
        Customer customer = customerService.findCustomerByPhone(phone).orElse(null);
        if (customer == null) {
            customer = new Customer();
            customer.setName(name);
            customer.setAddress(address);
            customer.setPhone(phone);
            customer.setEmail(email);
            customerService.create(customer);
        }
        Product product = productService.findById(Integer.parseInt(productID)).orElse(null);
        Order order = new Order(
                LocalDate.now(),
                Integer.parseInt(quantity),
                product,
                customer
        );
        // convert order to json
        String jsonOrder = Encrypt.encrypt(gson.toJson(order));
        // send order to message queue
        template.convertAndSend("order_product", jsonOrder);
        mav.addObject("products", productService.findAll());
        return mav;
    }
}
