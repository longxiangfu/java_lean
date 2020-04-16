//package com.lxf.reactorDemo.lean1;
//
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import io.swagger.annotations.ApiParam;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.*;
//import reactor.core.publisher.Flux;
//import reactor.core.publisher.Mono;
//
///**
// * @Description webflux（reactor）增删改查
// * @Author Administrator
// * @DATE 2019/4/4 16:37
// * @Version 1.0
// **/
//@Controller
//@RequestMapping("/city")
//@Api(tags = "Mogo练习")
//public class CityWebFluxController {
//    @Autowired
//    private CityService cityService;
//
//    @ApiOperation("保存城市")
//    @PostMapping
//    @ResponseBody
//    public Mono<City> saveCity(@ApiParam(name = "city", value = "城市") @RequestBody City city){
//        return cityService.saveCity(city);
//    }
//
//    @ApiOperation("根据id查询城市")
//    @GetMapping("/{id}")
//    @ResponseBody
//    public Mono<City> findCityById(@ApiParam(name = "id", value = "城市id") @PathVariable("id") String id){
//        return cityService.findCityById(id);
//    }
//
//    @ApiOperation("查询所有城市")
//    @GetMapping
//    @ResponseBody
//    public Flux<City> findAllCity(){
//        Flux<City> cityFlux = cityService.findAllCity();
//        return cityFlux;
//    }
//
//    @ApiOperation("修改城市")
//    @PutMapping
//    @ResponseBody
//    public Mono<City> modifyCity(@ApiParam(name = "city", value = "城市") @RequestBody City city){
//        return cityService.modifyCity(city);
//    }
//
//    @ApiOperation("根据id删除城市")
//    @DeleteMapping
//    @ResponseBody
//    public Mono<String> deleteCity(@ApiParam(name = "id", value = "城市id") @RequestParam(value = "id",required = false) String id){
//        City city = new City();
//        city.setId(id);
//        return cityService.deleteCity(city);
//    }
//}
