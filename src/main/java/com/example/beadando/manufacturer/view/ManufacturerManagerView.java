package com.example.beadando.manufacturer.view;

import com.example.beadando.core.component.MenuComponent;
import com.example.beadando.manufacturer.entity.ManufacturerEntity;
import com.example.beadando.manufacturer.service.ManufacturerService;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

//http://localhost:8081/manufacturermanager
@Route
public class ManufacturerManagerView extends VerticalLayout {
    private ManufacturerEntity selectedManufacturer;
    private VerticalLayout form;
    private TextField name;
    private Binder<ManufacturerEntity> binder;

    @Autowired
    private ManufacturerService service;


    @PostConstruct
    public void init() {
        add(new MenuComponent());
        Grid<ManufacturerEntity> grid = new Grid<>();
        grid.setItems(service.findAll());
        grid.addColumn(ManufacturerEntity::getId).setHeader("ID");
        grid.addColumn(ManufacturerEntity::getName).setHeader("Name");

        addButtonBar(grid);
        add(grid);
        addForm(grid);
    }

    private void addForm(Grid<ManufacturerEntity> grid) {
        form = new VerticalLayout();
        binder = new Binder<>(ManufacturerEntity.class);
        name = new TextField();
        form.add(new Text("Manufacturer Name"), name);

        Button saveBtn = new Button();
        saveBtn.setText("Save");
        saveBtn.addClickListener(buttonClickEvent -> {
            if (selectedManufacturer.getId() != null) {
                service.update(selectedManufacturer);
            } else {
                service.create(selectedManufacturer);
            }
            grid.setItems(service.findAll());
            form.setVisible(false);
        });
        form.add(saveBtn);
        add(form);
        form.setVisible(false);
        binder.bindInstanceFields(this);

    }

    private void addButtonBar(Grid<ManufacturerEntity> grid) {
        HorizontalLayout buttonBar = new HorizontalLayout();

        Button deleteBTN = new Button();
        deleteBTN.setEnabled(false);
        deleteBTN.setText("Delete");
        deleteBTN.setIcon(VaadinIcon.TRASH.create());
        deleteBTN.addClickListener(buttonClickEvent -> {
            service.deteteById(selectedManufacturer.getId());
            grid.setItems(service.findAll());
            selectedManufacturer = null;
            deleteBTN.setEnabled(false);
            form.setVisible(false);
            Notification.show("Succesfully Deleted");
        });

        grid.asSingleSelect().addValueChangeListener(event -> {
            selectedManufacturer = event.getValue();
            deleteBTN.setEnabled(selectedManufacturer != null);
            form.setVisible(selectedManufacturer != null);
            binder.setBean(selectedManufacturer);


        });

        Button addBtn = new Button();
        addBtn.setText("Add");
        addBtn.addClickListener(buttonClickEvent -> {
            selectedManufacturer = new ManufacturerEntity();
            binder.setBean(selectedManufacturer);
            form.setVisible(true);
        });
        addBtn.setIcon(VaadinIcon.PLUS.create());
        buttonBar.add(deleteBTN, addBtn);
        add(buttonBar);

    }


}
