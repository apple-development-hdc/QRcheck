package QRcheck.com.apple.repository;

import QRcheck.com.apple.Model.Validator;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ValidRepository extends MongoRepository<Validator,String> {
}
