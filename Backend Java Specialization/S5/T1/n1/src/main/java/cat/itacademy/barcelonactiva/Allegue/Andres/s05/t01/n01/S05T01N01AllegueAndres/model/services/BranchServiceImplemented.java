package cat.itacademy.barcelonactiva.Allegue.Andres.s05.t01.n01.S05T01N01AllegueAndres.model.services;

import cat.itacademy.barcelonactiva.Allegue.Andres.s05.t01.n01.S05T01N01AllegueAndres.model.domain.Branch;
import cat.itacademy.barcelonactiva.Allegue.Andres.s05.t01.n01.S05T01N01AllegueAndres.model.dto.BranchDTO;
import cat.itacademy.barcelonactiva.Allegue.Andres.s05.t01.n01.S05T01N01AllegueAndres.model.dto.EUCountries;
import cat.itacademy.barcelonactiva.Allegue.Andres.s05.t01.n01.S05T01N01AllegueAndres.model.repositories.BranchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BranchServiceImplemented implements BranchService {
    @Autowired
    private BranchRepository repository;

    @Override
    public BranchDTO add(BranchDTO branchDTO) {
        Branch branchToSave = convertToNonDTO(branchDTO);
        return convertToDTO(repository.save(branchToSave));
    }

    @Override
    public BranchDTO getOne(int id) {
        return null;
    }

    @Override
    public List<BranchDTO> getAll() {
        return List.of();
    }

    @Override
    public BranchDTO update(BranchDTO branchDTO) {
        return null;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    private BranchDTO convertToDTO(Branch branch){
        String type = EUCountries.getBranchType(branch.getCountry()).name();
        return new BranchDTO(branch.getId(), branch.getName(), branch.getCountry(), type);
    }
    private Branch convertToNonDTO(BranchDTO branchDTO){
        return Branch.builder()
                .name(branchDTO.name())
                .country(branchDTO.country())
                .build();
    }
}