package QRcheck.com.apple.repository;

import QRcheck.com.apple.Model.Generator;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface QrRepository extends MongoRepository<Generator, String > {


   List<Generator> findByHash(String hash);


}
