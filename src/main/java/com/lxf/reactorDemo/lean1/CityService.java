//package com.lxf.reactorDemo.lean1;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import reactor.core.publisher.Flux;
//import reactor.core.publisher.Mono;
//
//import java.util.List;
//
///**
// * @Description
// * @Author Administrator
// * @DATE 2019/4/4 16:13
// * @Version 1.0
// **/
//@Service
//public class CityService {
//
//    @Autowired
//    private CityRepository cityRepository;
//
//    /**
//     * 保存单个
//     * @param city
//     * @return
//     */
//    public Mono<City> saveCity(City city){
//        return cityRepository.save(city);
//    }
//
//    /**
//     * 保存所有
//     * @param cities
//     * @return
//     */
//    public Flux<City> saveAllCity(List<City> cities){
//        return cityRepository.saveAll(cities);
//    }
//
//
//    /**
//     * 根据id查询
//     * @param id
//     * @return
//     */
//    public Mono<City> findCityById(String id){
//        return cityRepository.findById(id);
//    }
//
//    /**
//     * 查询所有
//     * @return
//     */
//    public Flux<City> findAllCity(){
//        return cityRepository.findAll();
//    }
//
//    /**
//     * 修改
//     * @param city
//     * @return
//     */
//    public Mono<City> modifyCity(City city){
//        //根据id修改，若没有id对应数据，则新建
//        return cityRepository.save(city);
//    }
//
//    /**
//     * 删除
//     * @param city
//     * @return
//     */
//    public Mono<String> deleteCity(City city){
////        cityRepository.deleteById(city.getId());
//        cityRepository.delete(city);
//        return Mono.create(cityMonoSink -> cityMonoSink.success(city.getId()));
//    }
//
//
//}
