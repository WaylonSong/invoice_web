package invoice.repository.hiber;

import invoice.dataobject.Reimbursement;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by song on 2016/12/22.
 */
@Repository
public interface ReimburseRepository extends CrudRepository<Reimbursement, Integer>{
}
