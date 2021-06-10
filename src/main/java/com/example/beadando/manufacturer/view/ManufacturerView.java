package com.example.beadando.manufacturer.view;

import com.example.beadando.manufacturer.entity.ManufacturerEntity;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route
public class ManufacturerView extends VerticalLayout {
private  ManufacturerEntity selectedManufacturer;
    public ManufacturerView(){
        //adat
        Grid<ManufacturerEntity> grid=new Grid<>();
        grid.setItems(adat);
        grid.addColumn(ManufacturerEntity::getId).setHeader("ID");
        grid.addColumn(ManufacturerEntity::getName).setHeader("Neve");

        Button deleteBTN=new Button();
        deleteBTN.setEnabled(false);
        deleteBTN.setText("Törlés");
        deleteBTN.addClickListener(buttonClickEvent -> {

            adat.remove(selectedManufacturer);
            grid.setItems(adat);
            selectedManufacturer=null;
            deleteBTN.setEnabled(false);
        });

        grid.asSingleSelect().addValueChangeListener(event ->{
            selectedManufacturer=event.getValue();
            deleteBTN.setEnabled(selectedManufacturer!=null);
        });
        add(deleteBTN);
        add(grid);


    }
}
