package com.mnwise.wiseu.license.service;

import com.mnwise.wiseu.license.domain.CustType;
import com.mnwise.wiseu.license.dto.CustTypeDTO;
import com.mnwise.wiseu.license.repository.CustTypeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.IntStream;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
@Slf4j
public class CustTypeService {
    private final CustTypeRepository custTypeRepository;
    private final ModelMapper modelMapper;

    @Transactional
    public void save(Long id, List<String> names) {
        try{
            String name = validateCustName(names);
//            CustType custType = Optional.ofNullable(custTypeDTO.getId())
//                            .map(custTypeRepository::findOne)
//                                    .orElse(modelMapper.map(custTypeDTO, CustType.class));

//            custTypeRepository.save(custType);
//            CustType custType  = new CustType();
            CustType custType = CustType.builder()
                    .name(name)
                    .build();

            custTypeRepository.save(custType);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String validateCustName(List<String> names) {
       int count =  (int) names
                .stream()
                .map(custTypeRepository::findByName)
                .flatMapToInt(list -> IntStream.range(0, list.size()))
                .count();
       if(count == names.size()) {
           throw new IllegalStateException("유형 명은 중복 될 수 없습니다.");
       }

       String result = "";
        for (String name : names) {
            result += name + "/";
        }
        if(result.endsWith("/")) {
            result = result.substring(0, result.length()-1);
        }
       return result;
    }

    public CustTypeDTO findOne(Long id) {
        return modelMapper.map(custTypeRepository.findById(id), CustTypeDTO.class);
    }
}
