/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ws.c.project04.wscproject04;

import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ws.c.project04.wscproject04.products.Product;

/**
 *
 * @author STRIX
 */
@RestController
public class ProductServiceController {
    private static Map<String, Product> productRepo = new HashMap<>();
   static {
      Product honey = new Product();
      honey.setId("1");
      honey.setName("TEH TARIK");
      honey.setHarga("5000");
      honey.setJumlah("1");
      productRepo.put(honey.getId(), honey);
      
      Product almond = new Product();
      almond.setId("2");
      almond.setName("ES KEPAL");
      almond.setHarga("21000");
      almond.setJumlah("3");
      productRepo.put(almond.getId(), almond);
   }
   @RequestMapping(value = "/products")
   public ResponseEntity<Object> getProduct() {
      return new ResponseEntity<>(productRepo.values(), HttpStatus.OK);
   }
   
   @RequestMapping(value = "/products/{id}", method = RequestMethod.DELETE)
   public ResponseEntity<Object> delete(@PathVariable("id")String id){
       productRepo.remove(id);
       return new ResponseEntity<>("Product is deleted Successfully", HttpStatus.OK);
   }
   
   @RequestMapping(value = "/products/{id}", method = RequestMethod.PUT)
   public ResponseEntity<Object> updateProduct(@PathVariable("id")String id, @RequestBody Product product){
       if(!productRepo.containsKey(id)){
           return new ResponseEntity<>("Product key is wrong", HttpStatus.OK);
       }else{
           productRepo.remove(id);
           product.setId(id);
           productRepo.put(id, product);
           return new ResponseEntity<>("Product is updated Successfully", HttpStatus.OK);
       }
       
   }
   @RequestMapping(value = "/products", method = RequestMethod.POST)
   public ResponseEntity<Object> createProduct(@RequestBody Product product) {
       if (productRepo.containsKey(product.getId())){
           return new ResponseEntity<>("Product key can't duplicate", HttpStatus.OK);
       }else{
           productRepo.put(product.getId(), product);
           return new ResponseEntity<>("Product is created successfully", HttpStatus.CREATED);
       }
   }
}
