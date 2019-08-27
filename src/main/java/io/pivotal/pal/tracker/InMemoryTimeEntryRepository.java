package io.pivotal.pal.tracker;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

import static java.util.Arrays.asList;

public class InMemoryTimeEntryRepository implements TimeEntryRepository {

    public long entryId;

    Map<Long, TimeEntry> entryMap = new HashMap<>();

    @Override
    public TimeEntry create(TimeEntry timeEntryToCreate) {

        long id = ++entryId;
        timeEntryToCreate.setId(id);

        entryMap.put(timeEntryToCreate.getId(),timeEntryToCreate);

        return entryMap.get(id);

    }

    @Override
    public TimeEntry find(long timeEntryId) {

        return entryMap.get(timeEntryId);
    }


    @Override
    public List<TimeEntry> list() {
        List<TimeEntry> entries = new ArrayList<>();
        Set<Long> keySet = entryMap.keySet();
        for(Long key : keySet){
            entries.add(entryMap.get(key));
        }

        return entries;
    }

    @Override
    public TimeEntry update(long id, TimeEntry timeEntry) {

        timeEntry.setId(id);
        entryMap.replace(id,timeEntry);

        return entryMap.get(id);
    }

    @Override
    public void delete(long id) {
        entryMap.remove(id);

    }

}
