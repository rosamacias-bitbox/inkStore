package com.store.warehouse.management.services;

public interface SecurityService {

   public String findLoggedInUsername();
   public void autoLogin(String username, String password);

}
