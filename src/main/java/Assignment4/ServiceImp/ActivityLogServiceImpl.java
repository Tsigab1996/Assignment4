package Assignment4.ServiceImp;

import Assignment4.Entity.ActivityLog;
import Assignment4.Repository.ActivityLogRepository;
import Assignment4.Service.ActivityLogService;
import lombok.AllArgsConstructor;

import javax.annotation.security.DenyAll;

@AllArgsConstructor

public class ActivityLogServiceImpl implements ActivityLogService {
    private final ActivityLogRepository repository;

    @Override
    public ActivityLog logExecutionTime(ActivityLog log) {
        return repository.save(log);
    }
}