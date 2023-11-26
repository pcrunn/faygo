package me.pcrunn.faygo.arena;

import lombok.*;
import me.pcrunn.faygo.utility.Loc;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
@ToString
public class Arena {

    @NonNull
    private String name;

    private Loc loc1;
    private Loc loc2;

}
