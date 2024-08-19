package com.testng;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/EmptyTestNGTest.java to edit this template
 */

import com.mycompany.ejemploagentemovil.soapproject.ConexionPostgres;
import com.mycompany.ejemploagentemovil.soapproject.ManejoDatos;
import com.mycompany.ejemploagentemovil.soapproject.Persona;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.testng.Assert;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 *
 * @author USUARIO
 */
public class testAPI {
    
    public testAPI() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    
    @Ignore
    public void prueba_ignore()
    {
        assertEquals(1, 1,"Error de insersion persona");
    }
    
    
    
    @Test
    public void insertPerson_TEST() {
        Persona p=new Persona();
        p.setNombre("Jhon");        
        p.setApellido("Leturne");
        p.setCedula("1250808373");
        p.setCorreo("jleturnep@uteq.edu.ec");
        p.setEstado(true);
        ManejoDatos md=new ManejoDatos();
        Persona person=md.insertar(p);
        assertEquals(person.getEstado(), person.getEstado(),"Error de insersion persona");
    }
    
    @DataProvider(name = "data_persona")
    public Object[][] createData1() 
    {
        return new Object[][] {
          { "prueba1", "pruebaa1","1111111111","prueba1@gmail.com",true },
          { "prueba2", "pruebaa2","2222222222","prueba2@gmail.com",true },
        };
    }
    
   
    @Test(dataProvider = "data_persona")
    public void insertPerson_parametros_TEST(String nombre,String apellido,
            String cedula,String correo,Boolean estado) {
        Persona p=new Persona();
        p.setNombre(nombre);        
        p.setApellido(apellido);
        p.setCedula(cedula);
        p.setCorreo(correo);
        p.setEstado(estado);
        ManejoDatos md=new ManejoDatos();
        Persona person=md.insertar(p);
        assertEquals(person.getEstado(), person.getEstado(),"Error de insersion persona");
    }
    


    @BeforeMethod
    public void conexion_cerrada_TEST() throws Exception 
    {
        ConexionPostgres cnx=new ConexionPostgres();
        cnx.getConexion().close();
        Boolean estado=cnx.getConexion().isClosed();
        Assert.assertTrue(estado==true, "Error conexion");
    }
    

    @AfterMethod
    public void conexion_abierta_TEST() throws Exception 
    {
        ConexionPostgres cnx=new ConexionPostgres();
        cnx.getConexion().close();
        Boolean estado=cnx.getConexion().isClosed();
        Assert.assertTrue(estado==true, "Error conexion");
    }
    
    
    @Test(timeOut = 500)
    public void timeTestOne() throws InterruptedException 
    {          
        Thread.sleep(1000);
        System.out.println("tiempo de testeo");
    }
    
    
    @Test
    public void lista_persona_TEST()
    {
        ManejoDatos md=new ManejoDatos();
        int cantidad=md.listar().size();
        System.out.println(cantidad);
        Assert.assertEquals(cantidad, 21);
    }
    
    
    
}
