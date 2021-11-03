# Gilded Rose Refactoring Kata

This is my implementation of the Gilded Rose kata, as found on
[Emily Bache's github repo](https://github.com/emilybache/GildedRose-Refactoring-Kata), which in turn was originally
created by Terry Hughes (http://twitter.com/TerryHughes).

The steps I've taken along the way are documented in the git checkins. If memory serves, the original ask of the kata -
enable a new item type "Conjured" - was fulfilled about the 20th commit if you are looking for that point in particular.

I took a slightly curvy line focus towards completing it, as I am using this as an exercise to learn Kotlin and to get
back into the flow of development having been post-technical for a while. It is illustrative of how I prefer to work -
test-driven; incremental discrete (mostly) checkins; extract domain concepts; increasingly functional. I tend to tackle
the problem from the domain perspective. IOW, can I model the domain and is it logically consistent?

As a general point, having a reason to generate list with the updated characteristics would go a long way for people
like me. I artificially put it in the context of creating a report to be used for inventory-pulling or ordering, just to
give it some boundaries. In the course of doing that, it highlighted some interesting bugs in the original
implementation that wouldn't have been caught just by adding another branch on the tree, so to speak.

I also discovered a few things that would benefit from more clarification.

+ Is `"Conjured` a type of item or a manufacturing process? Does it's 2x degradation apply to the underlying Item's
  quality increment, or is it a consistent '-2'? Because the spec referred to as degrading, I implemented it as a type
  all it's own. An interesting exercise for a coding exercise would be to transform this working kata to take the
  alternative understanding of `Conjured`
+ Calling an attribute `sellin` without any context as to what happens after it expires?
+ The sample data from the fixture does not always represent a viable Item. I'm looking at
  you `Sulfuras, Hand of Ragnaros, -1, 80`. And how bad must this `Aged Brie", 2, 0` have been if it's at nil points
  just before it goes on the sale rack?
+ As presented (and not changed by my implementation), the Item's name is an indicator of behaviour, but isn't a
  defining characteristic. e.g. Will all `Legendary Items` behave the same way?

These last few points in particular helped me stave off using composition to encapsulate behaviour ***by type*** into
functions too quickly. While I think there's room for improvement in how Item's update themselves, this is
representative of how I would approach a legacy codebase. The other option of writing a new version to the constraints
in the kata would, I'm sure, create a whole different implementation.

If I continue using this work as a learning platform, the next thing to tackle would be Item creation. Although it's
beyond the ask of the kata, I think GildedRose (the file/bag o' functions) as it stands would make a reasonable entry
point to the inventory, I can explore the separation of Actions/Calculations/Data at a higher level.


