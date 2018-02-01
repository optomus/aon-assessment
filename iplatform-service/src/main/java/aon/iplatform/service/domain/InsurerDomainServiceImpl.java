package aon.iplatform.service.domain;

import aon.iplatform.domain.model.insurer.Insurer;
import aon.iplatform.domain.repository.InsurerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 */
@Service
public class InsurerDomainServiceImpl implements InsurerDomainService {

    @Autowired
    private InsurerRepository insurerRepository;


    @Override
    public List<Insurer> getInsurers() {
        return insurerRepository.getInsurers();
    }
}
