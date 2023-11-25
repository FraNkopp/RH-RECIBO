/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recibo.repositorios;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import recibo.entidades.Recibo;

/**
 *
 * @author FraNko
 */
@Repository
public interface ReciboRepositorio extends JpaRepository<Recibo, String>{
    
}
