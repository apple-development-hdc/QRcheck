package QRcheck.com.apple.repository;

import QRcheck.com.apple.Model.CodeKeeper;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface CodeRepository extends MongoRepository<CodeKeeper,String> {


}
