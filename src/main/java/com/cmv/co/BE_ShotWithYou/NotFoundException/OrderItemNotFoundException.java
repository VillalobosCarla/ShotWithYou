package com.cmv.co.BE_ShotWithYou.NotFoundException;

public class OrderItemNotFoundException extends RuntimeException {
    public OrderItemNotFoundException(Long id){
        super("Could not found Order Item with " + id);

    }

}