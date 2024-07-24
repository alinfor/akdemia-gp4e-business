package af.cmr.indyli.akdemia.business.service.impl;

import java.nio.file.AccessDeniedException;
import java.util.Date;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import af.cmr.indyli.akdemia.business.dao.ITrainerRepository;
import af.cmr.indyli.akdemia.business.dto.basic.TrainerBasicDTO;
import af.cmr.indyli.akdemia.business.dto.full.TrainerFullDTO;
import af.cmr.indyli.akdemia.business.entity.Trainer;
import af.cmr.indyli.akdemia.business.exception.AkdemiaBusinessException;
import af.cmr.indyli.akdemia.business.service.ITrainerService;
import af.cmr.indyli.akdemia.business.service.IUserService;
import af.cmr.indyli.akdemia.business.utils.ConstBusinessRules;
import af.cmr.indyli.akdemia.business.utils.ConstsValues;
import jakarta.annotation.Resource;

@Service(ConstsValues.ServiceKeys.TRAINER_SERVICE_KEY)
public class TrainerServiceImpl extends AbstractAkdemiaServiceImpl<Trainer, TrainerBasicDTO, TrainerFullDTO, ITrainerRepository> implements ITrainerService {

	@Resource(name = ConstsValues.ConstsDAO.TRAINER_DAO_KEY)
    private ITrainerRepository trainerRepository;

    @Resource(name = ConstsValues.ServiceKeys.USER_SERVICE_KEY)
    private IUserService userService;

    public TrainerServiceImpl() {
        super(Trainer.class, TrainerBasicDTO.class, TrainerFullDTO.class);
    }

    @Override
    public ITrainerRepository getDAO() {
        return this.trainerRepository;
    }

    @Override
    public TrainerFullDTO create(TrainerFullDTO view) throws AkdemiaBusinessException {
        if (!userService.isExistUserByEmail(view.getEmail())) {
            view.setCreationDate(new Date());
            Trainer entity = this.getDAO().saveAndFlush(this.getModelMapper().map(view, Trainer.class));

            return this.getModelMapper().map(entity, TrainerFullDTO.class);
        }
        throw new AkdemiaBusinessException(ConstBusinessRules.RG02);
    }

    @Override
    public TrainerFullDTO update(TrainerFullDTO viewToUpdate) throws AkdemiaBusinessException, AccessDeniedException {
        if (!userService.isExistUserByEmail(viewToUpdate.getEmail(), viewToUpdate.getId())) {
            viewToUpdate.setUpdateDate(new Date());
            Trainer entity = this.getDAO().findById(viewToUpdate.getId()).orElse(null);
            if (entity != null) {
                BeanUtils.copyProperties(viewToUpdate, entity);
                this.getDAO().saveAndFlush(entity);
            } else {
                throw new AkdemiaBusinessException("L'objet à modifier N'existe pas en Base...");
            }
            return viewToUpdate;
        }
        throw new AkdemiaBusinessException(ConstBusinessRules.RG02);
    }

    @Override
    public void deleteById(int id) throws AkdemiaBusinessException, AccessDeniedException {
        var tmpTrainer = this.findById(id);

        if (tmpTrainer == null) {
            throw new AkdemiaBusinessException("L'objet à supprimer n'existe pas en Base...");
        }

        getDAO().deleteById(id);
    }


}
