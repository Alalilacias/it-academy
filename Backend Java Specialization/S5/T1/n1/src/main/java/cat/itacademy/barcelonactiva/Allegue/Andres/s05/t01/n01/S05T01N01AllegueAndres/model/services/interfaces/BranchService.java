package cat.itacademy.barcelonactiva.Allegue.Andres.s05.t01.n01.S05T01N01AllegueAndres.model.services.interfaces;

import cat.itacademy.barcelonactiva.Allegue.Andres.s05.t01.n01.S05T01N01AllegueAndres.model.dto.BranchAddRequest;
import cat.itacademy.barcelonactiva.Allegue.Andres.s05.t01.n01.S05T01N01AllegueAndres.model.dto.BranchDTO;

import java.util.List;

@SuppressWarnings("unused")
public interface BranchService {
    BranchDTO add(BranchAddRequest addRequest);
    BranchDTO getOne(int id);
    List<BranchDTO> getAll();
    BranchDTO update(BranchDTO branchDTO);
    boolean delete(int id);
}
