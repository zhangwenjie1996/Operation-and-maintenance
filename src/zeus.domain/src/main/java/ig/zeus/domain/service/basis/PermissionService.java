package ig.zeus.domain.service.basis;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import ig.zeus.domain.model.permission.Permission;
import ig.zeus.domain.repository.command.IPermissionRepository;
import ig.zeus.domain.service.IPermissionService;

public class PermissionService implements IPermissionService {
    private IPermissionRepository iPermissionRepository;

    /**
     * @return the iPermissionRepository
     */
    public IPermissionRepository getiPermissionRepository() {
        return iPermissionRepository;
    }

    /**
     * @param iPermissionRepository the iPermissionRepository to set
     */
    public void setiPermissionRepository(IPermissionRepository iPermissionRepository) {
        this.iPermissionRepository = iPermissionRepository;
    }

    @Override
    public int addRoleSystem(int roleId, int[] systemIds) {
        List<Permission> list = new ArrayList<>();
        IntStream.of(systemIds).filter(s -> s != -1).forEach((s) -> {
            Permission permission = new Permission(roleId, s, (byte) 1);
            list.add(permission);
        });
        int x = 0;
        if (!list.isEmpty()) {
            x = this.iPermissionRepository.addRoleSystem(list);
        }
        return x;
    }

    @Override
    public int addRoleElement(int roleId, int[] elementIds, int[] permissions) {
        List<Permission> list = new ArrayList<>();
        for (int i = 0; i < elementIds.length; i++) {
            if (elementIds[i] != -1 && elementIds[i] != 0) {
                Permission permission = new Permission(roleId, elementIds[i], (byte) permissions[i]);
                list.add(permission);
            }
        }
        int x = 0;
        if (!list.isEmpty()) {
            x = this.iPermissionRepository.addRoleElement(list);
        }
        return x;
    }

    @Override
    public int addRoleMenu(int roleId, int[] menuIds) {
        List<Permission> list = new ArrayList<>();
        IntStream.of(menuIds).filter(m -> m != -1).forEach((s) -> {
            Permission permission = new Permission(roleId, s, (byte) 1);
            list.add(permission);
        });
        int x = 0;
        if (!list.isEmpty()) {
            x = this.iPermissionRepository.addRoleMenu(list);
        }
        return x;
    }

    @Override
    public boolean removeRoleMenu(int roleId) {
        return this.iPermissionRepository.removeRoleMenu(roleId);
    }

    @Override
    public boolean removeRoleElement(int roleId) {
        return this.iPermissionRepository.removeRoleElement(roleId);
    }

    @Override
    public boolean removeRoleSystem(int roleId) {
        return this.iPermissionRepository.removeRoleSystem(roleId);
    }
}
