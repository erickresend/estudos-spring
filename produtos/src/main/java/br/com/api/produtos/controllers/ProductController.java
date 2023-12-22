package br.com.api.produtos.controllers;

import br.com.api.produtos.models.ProductModel;
import br.com.api.produtos.models.ResponseModel;
import br.com.api.produtos.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
//liberar o cors
@CrossOrigin(origins = "*")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping("createProduct")
    public ResponseEntity<Object> createProduct(@RequestBody ProductModel productModel){
        return productService.createUpdateProduct(productModel, "cadastrar");
    }

    @GetMapping("listAllProducts")
    public Iterable<ProductModel> listAll(){
        return productService.listAll();
    }


    @GetMapping
    public String rote(){
        return "API de produtos funcionando";
    }

    @PutMapping("updateProduct")
    public ResponseEntity<Object> updateProduct(@RequestBody ProductModel productModel){
        return productService.createUpdateProduct(productModel, "alterar");
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity<ResponseModel> remove(@PathVariable Long id){
        return productService.remove(id);
    }
}
