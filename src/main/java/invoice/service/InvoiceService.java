package invoice.service;

import invoice.dataobject.Invoice;
import invoice.repository.hiber.InvoiceRepository;
import invoice.repository.hiber.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import util.Result;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by song on 2016/12/20.
 */
@Service
public class InvoiceService extends BaseService{
    @Resource
    InvoiceRepository invoiceRepository;
    @Resource
    UserRepository userRepository;

    @Transactional
    public Result add(Invoice invoice) {
        return resultWrap(invoiceRepository.save(invoice));
    }

    @Transactional Result update(Invoice invoice){
        return add(invoice);
    }

    @Transactional Invoice findByNumber(String number){
        return invoiceRepository.findOne(number);
    }

    @Transactional
    public List<Invoice> findAll() {
        return (List<Invoice>) invoiceRepository.findAll();
    }
}
