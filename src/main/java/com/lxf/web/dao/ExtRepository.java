//package com.lxf.web.dao;
//
//import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Transactional;
//
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//import java.util.Iterator;
//
//@Repository
//@Transactional(rollbackFor = Exception.class)
//public class ExtRepository<T> {
//    private static final int BATCH_SIZE = 10;
//
//    @PersistenceContext
//    private EntityManager em;
//
//
//    public void  batchSave(Iterable<T> var){
//        Iterator<T> iterator = var.iterator();
//        int index = 0;
//        while (iterator.hasNext()){
//            em.persist(iterator.next());
//            index++;
//            if (index % BATCH_SIZE == 0) {
//                em.flush();
//                em.clear();
//            }
//        }
//        em.flush();
//        em.clear();
//    }
//
//
//    public void  batchUpdate(Iterable<T> var){
//        Iterator<T> iterator = var.iterator();
//        int index = 0;
//        while (iterator.hasNext()){
//            em.merge(iterator.next());
//            index++;
//            if (index % BATCH_SIZE == 0) {
//                em.flush();
//                em.clear();
//            }
//        }
//        em.flush();
//        em.clear();
//    }
//
//}
