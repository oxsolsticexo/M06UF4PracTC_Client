/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;

import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author carlo
 */
public class Converts {
    
    public static ObservableList<?> convertToObservableList(List<?> list){
        return FXCollections.observableArrayList(list);
    }
}
