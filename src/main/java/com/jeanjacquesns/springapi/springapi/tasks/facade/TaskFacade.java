package com.jeanjacquesns.springapi.springapi.tasks.facade;

import com.jeanjacquesns.springapi.springapi.tasks.dto.TaskDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TaskFacade {
    private static final Map<Long, TaskDTO> tasks=new HashMap<>();

    public TaskDTO create(TaskDTO taskDTO){
        Long nextId=tasks.keySet().size()+1L;
        taskDTO.setId(nextId);
        tasks.put(nextId,taskDTO);

        return taskDTO;
    }
    public TaskDTO udpate(TaskDTO taskDTO,Long taskId){
        tasks.put(taskId,taskDTO);

        return taskDTO;
    }
    public TaskDTO getById(Long taskId){
        return tasks.get(taskId);
    }
    public List<TaskDTO> getAll(){
        return  new ArrayList<>(tasks.values());
    }
    public String delete(Long taskId){
        tasks.remove(taskId);
        return "DELETED";
    }
}
