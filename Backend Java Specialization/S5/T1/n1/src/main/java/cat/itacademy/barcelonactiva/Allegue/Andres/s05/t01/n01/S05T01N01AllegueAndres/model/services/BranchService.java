package cat.itacademy.barcelonactiva.Allegue.Andres.s05.t01.n01.S05T01N01AllegueAndres.model.services;

import cat.itacademy.barcelonactiva.Allegue.Andres.s05.t01.n01.S05T01N01AllegueAndres.model.dto.BranchDTO;

import java.util.List;

@SuppressWarnings("unused")
public interface BranchService {
    BranchDTO add(BranchDTO branchDTO);
    BranchDTO getOne(int id);
    List<BranchDTO> getAll();
    BranchDTO update(BranchDTO branchDTO);
    boolean delete(int id);
}
