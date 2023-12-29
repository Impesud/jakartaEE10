package com.impesud.products;

import jakarta.inject.*;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("/products")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProductController {

    @Inject
    private ProductService productService;

    @GET
    @Path("/{productId}")
    public Response getProductById(@PathParam("productId") long productId) {
        Product product = productService.getProductById(productId);
        if (product != null) {
            return Response.ok(product).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @GET
    public Response getAllProducts() {
        List<Product> products = productService.findAll();
        return Response.ok(products).build();
    }
}