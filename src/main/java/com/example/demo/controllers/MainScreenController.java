package com.example.demo.controllers;

import com.example.demo.domain.Part;
import com.example.demo.domain.Product;
import com.example.demo.repositories.PartRepository;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.service.PartService;
import com.example.demo.service.ProductService;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

/**
 *
 *
 *
 *
 */

@Controller
public class MainScreenController {
        private static final Logger logger = LoggerFactory.getLogger(MainScreenController.class);
   // private final PartRepository partRepository;
   // private final ProductRepository productRepository;'

    private PartService partService;
    private ProductService productService;

    private List<Part> theParts;
    private List<Product> theProducts;

 /*   public MainScreenControllerr(PartRepository partRepository, ProductRepository productRepository) {
        this.partRepository = partRepository;
        this.productRepository = productRepository;
    }*/

    public MainScreenController(PartService partService,ProductService productService){
        this.partService=partService;
        this.productService=productService;
    }
    @GetMapping("/mainscreen")
    public String listPartsandProducts(Model theModel, @Param("partkeyword") String partkeyword, @Param("productkeyword") String productkeyword){
        //add to the sprig model
        List<Part> partList=partService.listAll(partkeyword);
        theModel.addAttribute("parts",partList);
        theModel.addAttribute("partkeyword",partkeyword);
    //    theModel.addAttribute("products",productService.findAll());
        List<Product> productList=productService.listAll(productkeyword);
        theModel.addAttribute("products", productList);
        theModel.addAttribute("productkeyword",productkeyword);
        return "mainscreen";
    }
    @PostMapping ("/buyProduct")
    public String buyProduct(@RequestParam("productID") int productId) {
        /* Attempts to reduce inventory of product if purchased */
        try {
            Product product = productService.findById(productId);
            if (product.getInv() > 0) {
                product.setInv(product.getInv() - 1);
                productService.save(product);
                logger.info("Purchase successful - Product ID: {}, Name: {}, Remaining inventory: {}", productId, product.getName(), product.getInv());
                return "redirect:/purchaseSuccess";
            }
            /* Redirects to the error page if insufficient stock */
            else {
                return "redirect:/insufficientStock";
            }
        }
        /* Redirects to the error page if product not found */
        catch (Exception e) {
                    logger.error("Purchase failed - Product ID: {} not found or error occurred: {}", productId, e.getMessage());
            return "redirect:/insufficientStock";
        }
    }
    /* Mapping for purchase success and error pages */
    @GetMapping("/purchaseSuccess")
    public String purchaseSuccessPage() {
        return "purchaseSuccess";
    }
    @GetMapping("/insufficientStock")
    public String insufficientStockPage() {
        return "insufficientStock";
    }
}
