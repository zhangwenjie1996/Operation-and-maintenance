package ig.zeus.domain.service.basis;

import org.dozer.DozerBeanMapper;

import ig.zeus.domain.model.resource.System;
import ig.zeus.domain.repository.command.ISystemRespository;
import ig.zeus.domain.service.ISystemService;
import ig.zeus.domain.service.command.SystemCommand;

public class SystemService implements ISystemService {
    private DozerBeanMapper dozer = new DozerBeanMapper();
    private ISystemRespository iSystemRespository;
    private SystemCommand systemCommand;
    private System system;

    public ISystemRespository getiSystemRespository() {
        return iSystemRespository;
    }

    public void setiSystemRespository(ISystemRespository iSystemRespository) {
        this.iSystemRespository = iSystemRespository;
    }

    public SystemCommand getSystemCommand() {
        return systemCommand;
    }

    public void setSystemCommand(SystemCommand systemCommand) {
        this.systemCommand = systemCommand;
    }

    public System getSystem() {
        return system;
    }

    public void setSystem(System system) {
        this.system = system;
    }

    @Override
    public int remove(Integer id) {
        return iSystemRespository.remove(id);
    }

    @Override
    public int add(SystemCommand entity) {
        system = dozer.map(entity, System.class);
        iSystemRespository.add(system);
        return system.getID();
    }

    @Override
    public int update(SystemCommand entity) {
        system = dozer.map(entity, System.class);
        return iSystemRespository.update(system);
    }

}
