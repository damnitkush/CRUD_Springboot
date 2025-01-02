package net.engineeringdigest.journalApp.controller;


import net.engineeringdigest.journalApp.entity.JournalEntry;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;


@RestController
@RequestMapping("/journal")
public class JournalEntryController {

    private Map<Long , JournalEntry> journalEntries = new HashMap<>();

    @GetMapping()
    public List<JournalEntry> getAll(){
        return new ArrayList<>(journalEntries.values());
    }
    @PostMapping
    public boolean createEntry(@RequestBody JournalEntry myEntry){
        journalEntries.put(myEntry.getId(), myEntry);
        return true;

    }

    @GetMapping("id/{myId}")
    public JournalEntry getEntryById(@PathVariable Long myId){
        return journalEntries.get(myId);
    }

    @DeleteMapping("id/{myId}")
    public JournalEntry deleteEntryById(@PathVariable Long myId){
        return journalEntries.remove(myId);
    }

    @PutMapping("/id/{id}")
    public JournalEntry updateEntryById(@PathVariable Long id,@RequestBody JournalEntry myEntry){
        return journalEntries.put(id, myEntry);
    }

}