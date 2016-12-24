package invoice.service;

import invoice.dataobject.Invoice;
import invoice.dataobject.Reimbursement;
import invoice.dto.ReimbursementDTO;
import invoice.repository.hiber.InvoiceRepository;
import invoice.repository.hiber.ReimburseRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import util.Result;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by song on 2016/12/22.
 */
@Service
public class ReimburseService extends BaseService {
    @Resource
    ReimburseRepository reimburseRepository;
    @Resource
    InvoiceRepository invoiceRepository;
    @Resource
    TransferService transferService;

    @Transactional
    public Result<Reimbursement> add(ReimbursementDTO reimbursementDTO){
        Reimbursement reimbursement = new Reimbursement();
        BeanUtils.copyProperties(reimbursementDTO, reimbursement);
        List<Invoice> invoiceList = new ArrayList<Invoice>();
        for(String number : reimbursementDTO.getInvoiceNumberList()){
            Invoice invoice = new Invoice();
            invoice.setNumber(number);
            invoiceList.add(invoice);
            transferService.transfer(invoice.getOwnerId(), reimbursement.getCompanyTitle(), invoiceRepository.findOne(number));
        }
        reimbursement.setInvoiceList(invoiceList);
        return resultWrap(reimburseRepository.save(reimbursement));
    }
}
