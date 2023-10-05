/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.espe.edu.contacts.controller;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import ec.espe.edu.contacts.model.Contact;
import utils.DBManager;

/**
 *
 * @author Christian Novoa
 */
public class ContactController {
    public boolean addClient(Contact contact) {
        DBManager dbmanager = new DBManager();
        MongoClient mongo = dbmanager.connect();
        if(mongo != null){
            DB dataBase = mongo.getDB("Contacts");
            DBCollection collection = dataBase.getCollection("Contact");
            
            BasicDBObject document = new BasicDBObject();
            document.put("id", contact.getId());
            document.put("name", contact.getName());
            document.put("phoneNumber", contact.getPhoneNumber());
            document.put("description", contact.getDescription());
            
            collection.insert(document);
            return true;
        } else {
            return false;
        }
    }

    public ContactController() {
    }
    
}
