package invoice.controller;

/**
 * Created by song on 15/11/19.
 */
import com.google.gson.Gson;
import invoice.dataobject.Invoice;
import invoice.dto.TransferDTO;
import invoice.service.InvoiceService;
import invoice.service.TransferService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import util.Result;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Random;

@RestController
@EnableAutoConfiguration
//@ComponentScan("invoice.dataobject.*")
@RequestMapping("invoice")
public class InvoiceRestController {
    @Resource
    InvoiceService invoiceService;
    @Resource
    TransferService transferService;


//    @RequestMapping("/search")
//    public int getMessageCount(@RequestParam(value = "cusId", required = false, defaultValue = "0") int cusId) {
//        if (cusId == 0)
//            return 0;
//        List<Invoice> invoices = invoiceRepository.findByNumber(cusId);
//        return invoices.size();
//    }
    @RequestMapping(value = "", method = RequestMethod.POST)
    public Result add(@RequestBody Invoice invoice, HttpServletRequest request) {
        invoice.setOwnerId(invoice.getSeller().getTitle());
        Result<Invoice> result = invoiceService.add(invoice);
//        String jsonObject = new Gson().toJson(invoice);
//        System.out.println(jsonObject);
        return result;
    }

    @RequestMapping(value = "transfer", method = RequestMethod.POST)
    public Result transfer(@RequestBody TransferDTO transferDTO) {
        return transferService.transfer(transferDTO);
    }


    @RequestMapping("/total")
    public int getTotal() {
        List<Invoice> invoices = (List<Invoice>) invoiceService.findAll();
        return invoices.size();
    }

    @Transactional
    @RequestMapping("/save")
    public String save(){
        Invoice invoice = new Invoice();
        invoice.setNumber(""+new Random().nextInt());
        invoiceService.add(invoice);
        return invoice.getNumber();
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(InvoiceRestController.class, args);
    }
}
