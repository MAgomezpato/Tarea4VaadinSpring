package com.example;

import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.lang.String;

@SpringUI
@Theme("valo")

public class TodoUI extends UI {

    @Autowired
    PanaderiaRepository panaderiaRepository;

    @Override
    protected void init(VaadinRequest vaadinRequest) {

        VerticalLayout Vlayout = new VerticalLayout();

        Label titulo = new Label("Sistema de Gestion de Panaderias y Equipos para Panaderias");

        HorizontalLayout Hlayout0 = new HorizontalLayout();
        HorizontalLayout Hlayout = new HorizontalLayout();
        Hlayout.setMargin(false);
        HorizontalLayout Hlayout2 = new HorizontalLayout();
        HorizontalLayout Hlayout3 = new HorizontalLayout();
        Hlayout3.setWidth("75%");
        TextField codigo = new TextField("Codigo de Panaderia");
        TextField panaderia = new TextField("Nombre de Panaderia");
        TextField pedido = new TextField("Pedido");
        NativeSelect<String> equipo = new NativeSelect("Equipo Industrial");
        equipo.setItems("Horno","Amasadora","Batidora","Mesa de Trabajo","Clavijero","Bandejas");


        Grid<Panaderia> tabla = new Grid<>();

        tabla.addColumn(Panaderia::getId).setCaption("ID");
        tabla.addColumn(Panaderia::getCodigo).setCaption("Codigo de Panaderia");
        tabla.addColumn(Panaderia::getPanaderia).setCaption("Nombre de Panaderia");
        tabla.addColumn(Panaderia::getPedido).setCaption("Pedido");
        tabla.addColumn(Panaderia::getEquipo).setCaption("Equipo Industrial");
        tabla.setWidth("75%");
        Button agregar = new Button("Agregar");
        Button eliminar = new Button("Eliminar");
        agregar.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                Panaderia a = new Panaderia();
                a.setCodigo(Integer.parseInt(codigo.getValue()));
                a.setPanaderia(panaderia.getValue());
                a.setPedido(pedido.getValue());
                a.setEquipo(equipo.getValue());

                panaderiaRepository.save(a);
                tabla.setItems(panaderiaRepository.findAll());

                codigo.clear();
                panaderia.clear();
                pedido.clear();
                equipo.clear();
            }
        });
        eliminar.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                    Panaderia e = new Panaderia();
                    tabla.getSelectedItems();


            }
        });
        Hlayout0.addComponents(titulo);
        Hlayout.addComponents(codigo, panaderia, pedido, equipo);
        Hlayout2.addComponents(agregar, eliminar);
        Hlayout3.addComponents(tabla);

        Vlayout.addComponents(Hlayout0,Hlayout, Hlayout2, Hlayout3);

        setContent(Vlayout);

    }






}
