package cat.itacademy.barcelonactiva.Allegue.Andres.s05.t01.n01.S05T01N01AllegueAndres.model.services.interfaces;

import cat.itacademy.barcelonactiva.Allegue.Andres.s05.t01.n01.S05T01N01AllegueAndres.model.dto.BranchAddRequest;
import cat.itacademy.barcelonactiva.Allegue.Andres.s05.t01.n01.S05T01N01AllegueAndres.model.dto.BranchDTO;
import cat.itacademy.barcelonactiva.Allegue.Andres.s05.t01.n01.S05T01N01AllegueAndres.model.dto.BranchUpdateRequest;

import java.util.List;

@SuppressWarnings("unused")
public interface BranchService {
    BranchDTO add(BranchAddRequest addRequest);
    BranchDTO getOne(int id);
    List<BranchDTO> getAll();
    boolean update(BranchUpdateRequest branchUpdateRequest);
    boolean delete(int id);
}
