//package com.crud.CongresoIUD_DAO.service;
//
//import com.crud.CongresoIUD_DAO.model.PartidoPolitico;
//import com.crud.CongresoIUD_DAO.repository.IpartidoPoliticoRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class partidoPoliticoService {
//
//    HashMap <String, Object> datos;
//
//    private final IpartidoPoliticoRepository IpartidoPoliticoRepository;
//
//    @Autowired
//    public partidoPoliticoService(IpartidoPoliticoRepository IpartidoPoliticoRepository) {
//        this.IpartidoPoliticoRepository = IpartidoPoliticoRepository;
//    }
//
//    public List<PartidoPolitico> getPartido() {
//        return this.IpartidoPoliticoRepository.findAll();
//    }
//
//    public ResponseEntity<Object> addNewPartido(PartidoPolitico partidoPolitico){
//        Optional <PartidoPolitico> res = IpartidoPoliticoRepository.findPartidoPoliticoByNombre(partidoPolitico.getNombre());
//        datos = new HashMap<>();
//
//        if(res.isPresent() && partidoPolitico.getId() == 0 ){
//            datos.put("error", true);
//            datos.put("mensaje", "El partido ya existe");
//            return new ResponseEntity<>(
//                    datos,
//                    HttpStatus.CONFLICT
//            );
//        }
//
//        datos.put("mensaje", "El partido politico ha sido creado");
//
//        if(partidoPolitico.getId() != 0){
//            datos.put("mensaje", "El partido politico ha sido Modificado");
//        }
//
//        IpartidoPoliticoRepository.save(partidoPolitico);
//        datos.put("data", partidoPolitico);
//
//        return new ResponseEntity<>(
//                datos,
//                HttpStatus.CREATED
//        );
//    }
//
//    public ResponseEntity<Object> deletePartido(Long partidoPoliticoId){
//        datos = new HashMap<>();
//        boolean exists = IpartidoPoliticoRepository.existsById(partidoPoliticoId);
//
//        if(!exists){
//            datos.put("error", true);
//            datos.put("mensaje", "El partido politico no existe");
//            return new ResponseEntity<>(
//                    datos,
//                    HttpStatus.NOT_FOUND
//            );
//        }
//
//        this.IpartidoPoliticoRepository.deleteById(partidoPoliticoId);
//        datos.put("mensaje", "El partido politico ha sido eliminado");
//        return new ResponseEntity<>(
//                datos,
//                HttpStatus.OK
//        );
//    }
//
//}
