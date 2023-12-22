package br.com.api.produtos.services;

import br.com.api.produtos.models.ProductModel;
import br.com.api.produtos.models.ResponseModel;
import br.com.api.produtos.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ResponseModel responseModel;

    public Iterable<ProductModel> listAll(){
        return productRepository.findAll();
    }

    public ResponseEntity<Object> createUpdateProduct(ProductModel productModel, String action){

        if(productModel.getName().isEmpty()){
            responseModel.setMensage("O nome do produto é obrigatório");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseModel);
        } else if(productModel.getBrand().isEmpty()) {
            responseModel.setMensage("O nome da marca é obrigatório");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseModel);
        } else{
            if(action.equals("cadastrar")){
                return ResponseEntity.status(HttpStatus.CREATED).body(productRepository.save(productModel));
            } else {
                return ResponseEntity.status(HttpStatus.OK).body(productRepository.save(productModel));
            }
        }
    }

    public ResponseEntity<ResponseModel> remove(Long id){
        productRepository.deleteAllById(Collections.singleton(id));
        responseModel.setMensage("O produto foi removido com sucesso!");
        return ResponseEntity.status(HttpStatus.OK).body(responseModel);
    }
}
