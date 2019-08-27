package io.pivotal.pal.tracker;

import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface TimeEntryRepository {
    public TimeEntry create(TimeEntry timeEntryToCreate);
    public TimeEntry find(long timeEntryId);
    public List<TimeEntry> list();
    public TimeEntry update(long id, TimeEntry timeEntry);
    public void delete(long id);

}
