package QRcheck.com.apple.Controller;


import QRcheck.com.apple.Model.CodeKeeper;
import QRcheck.com.apple.Model.Generator;
import QRcheck.com.apple.Model.Validator;
import QRcheck.com.apple.Services.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/QRauth")
@Controller
@CrossOrigin("*")
public class controller {
@Autowired
    AppService appService;

@RequestMapping(method = RequestMethod.GET, value = "/data")
public List<Generator>getall(){
    return appService.allEmp();
}

@RequestMapping(method=RequestMethod.GET,value="/data/{id}")
public Optional<Generator> get(@PathVariable("id") String id){
        return appService.getEmp(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/add")
    public void add(@RequestBody Generator generator ){
        appService.newEmp(generator);
    }


    @RequestMapping(method= RequestMethod.DELETE, value="/del/{id}")
    public void  delete(@PathVariable("id") String id){
        appService.del(id);
    }

    @RequestMapping(method= RequestMethod.PUT, value = "/update/{id}")
    public void update(@PathVariable("id") String id ,@RequestBody Generator generator){
        appService.update(id,generator);
    }


    @RequestMapping(method=RequestMethod.GET, value="/code/{id}")
    public Optional<CodeKeeper> getToken(@PathVariable("id") String id){
    return appService.output(id);
    }



    @RequestMapping(method=RequestMethod.GET, value="/validate/{id}")
    public Optional<Validator> getValidate(@PathVariable("id") String id){
        return  appService.validate(id);
    }

}
