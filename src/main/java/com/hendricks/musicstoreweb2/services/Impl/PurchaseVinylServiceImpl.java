/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hendricks.musicstoreweb2.services.Impl;

import com.hendricks.musicstoreweb2.domain.Card;
import com.hendricks.musicstoreweb2.domain.Cash;
import com.hendricks.musicstoreweb2.domain.Cheque;
import com.hendricks.musicstoreweb2.domain.ProductPurchase;
import com.hendricks.musicstoreweb2.domain.PurchaseVinyl;
import com.hendricks.musicstoreweb2.repository.ProductPurchaseRepository;
import com.hendricks.musicstoreweb2.services.PurchaseVinylService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author kurvin
 */
@Service
public class PurchaseVinylServiceImpl implements PurchaseVinylService{
    @Autowired
    
    private ProductPurchaseRepository repo;
    private Long id;
    // if type = 1 cash, if 2 = cheque, if card 3. 
    @Override
    public Double buyDevice(String name, String type) {
       Cash c = null;
       Cheque ch = null;
       Card cd = null;
       
       Date d = new Date();
       
    switch (type) {
        case "c1":
            c = new Cash.Builder(d.toString())
                    .build();
            break;
        case "c2":
            ch = new Cheque.Builder(d.toString())
                    .build();
            break;
        case "c3":
            cd = new Card.Builder(d.toString())
                    .build();
            break;
    }
       
       
       PurchaseVinyl v = new PurchaseVinyl.Builder()
               .setName("Let The Good Times Role")
               .setPrice(3.99)
               .build();
       
       PurchaseVinyl v1 = new PurchaseVinyl.Builder()
               .setName("Thanks For The Meomories")
               .setPrice(3.99)
               .build();
       
       List<PurchaseVinyl> vinylList = new ArrayList();
       vinylList.add(v);
       vinylList.add(v1);
       
               
       ProductPurchase pc = new ProductPurchase.Builder(d)
               .setVinylPurchases(vinylList)
               .setCardPurchases(cd)
               .setCashPurchases(c)
               .setChequePurchases(ch)
               .build();
       
       repo.save(pc);
       id = pc.getID();
       
       ProductPurchase pc2 = repo.findOne(id);
            for(int x = 0; pc2.getVinylPurchases().size() > x; x++){
                if(pc2.getVinylPurchases().get(x).getName().equals(name)){
                    return pc2.getVinylPurchases().get(x).getPrice();
                }
            }
       return null;    
    }
}
