package cat.itacademy.barcelonactiva.Allegue.Andres.s05.t01.n01.S05T01N01AllegueAndres.model.services;

import cat.itacademy.barcelonactiva.Allegue.Andres.s05.t01.n01.S05T01N01AllegueAndres.exceptions.custom.BranchNotFoundException;
import cat.itacademy.barcelonactiva.Allegue.Andres.s05.t01.n01.S05T01N01AllegueAndres.exceptions.custom.NullBranchTypeException;
import cat.itacademy.barcelonactiva.Allegue.Andres.s05.t01.n01.S05T01N01AllegueAndres.model.domain.Branch;
import cat.itacademy.barcelonactiva.Allegue.Andres.s05.t01.n01.S05T01N01AllegueAndres.model.dto.BranchAddRequest;
import cat.itacademy.barcelonactiva.Allegue.Andres.s05.t01.n01.S05T01N01AllegueAndres.model.dto.BranchDTO;
import cat.itacademy.barcelonactiva.Allegue.Andres.s05.t01.n01.S05T01N01AllegueAndres.model.domain.enums.BranchType;
import cat.itacademy.barcelonactiva.Allegue.Andres.s05.t01.n01.S05T01N01AllegueAndres.model.domain.enums.EUCountries;
import cat.itacademy.barcelonactiva.Allegue.Andres.s05.t01.n01.S05T01N01AllegueAndres.model.dto.BranchUpdateRequest;
import cat.itacademy.barcelonactiva.Allegue.Andres.s05.t01.n01.S05T01N01AllegueAndres.model.repositories.BranchRepository;
import cat.itacademy.barcelonactiva.Allegue.Andres.s05.t01.n01.S05T01N01AllegueAndres.model.services.interfaces.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BranchServiceImplemented implements BranchService {
    @Autowired
    private BranchRepository branchRepository;

    @Override
    public BranchDTO add(BranchAddRequest branchAddRequest) {
        return convertToDTO(branchRepository.save(branchAddRequest.toBranch()));
    }

    @Override
    public BranchDTO getOne(int id) {
        return convertToDTO(branchRepository.findById(id)
                .orElseThrow(() -> new BranchNotFoundException("Branch with id " + id + " not found.")));
    }

    @Override
    public List<BranchDTO> getAll() {
        return branchRepository.findAll().stream()
                .map(BranchServiceImplemented::convertToDTO)
                .toList();
    }

    @Override
    public boolean update(BranchUpdateRequest branchUpdateRequest) {
        boolean isDifferent = false;
        Branch branchInRepository = branchRepository.findById(branchUpdateRequest.id()).orElseThrow();

        if(!branchInRepository.getName().equals(branchUpdateRequest.name())){
            branchInRepository.setName(branchUpdateRequest.name());
            isDifferent = true;
        }
        if(!branchInRepository.getCountry().equals(branchUpdateRequest.country())){
            branchInRepository.setCountry(branchUpdateRequest.country());
            isDifferent = true;
        }
        if(isDifferent){
            convertToDTO(branchRepository.save(branchInRepository));
        }

        return isDifferent;
    }

    @Override
    public boolean delete(int id) {
        Optional<Branch> optionalBranch = branchRepository.findById(id);
        if (optionalBranch.isPresent()){
            branchRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    private static BranchDTO convertToDTO(Branch branch) {
        if(branch == null){
            throw new NullBranchTypeException(BranchType.DTO);
        }

        String type = EUCountries.getBranchType(branch.getCountry()).name();
        return new BranchDTO(
                branch.getId(),
                branch.getName(),
                branch.getCountry(),
                type);
    }
}