---
layout: page
title: User Guide
---

TutAssistor is a ***desktop app for private tutors to manage tuition class time slots, optimized for use via a Command Line Interface (CLI)***. It enables tutors to resolve conflicts in their tuition schedule and manage their students more efficiently.

* Table of Contents
{:toc}

--------------------------------------------------------------------------------------------------------------------

## Quick start

TBA

--------------------------------------------------------------------------------------------------------------------

## Features

### Adding students/tuition classes
#### Adding a student: `add`
Adds a student’s information such as n/NAME, p/PHONE_NUMBER.

Format: `add n/NAME p/PHONE_NUMBER e/EMAIL a/ADDRESS [r/REMARK] [t/TAG]…`

Examples:
- `add n/John Doe p/98765432 e/johnd@example.com a/John street, block 123, #01-01`
- `add n/Richard Ng p/97865342 e/richardng@example.com a/Yishun Ave 1 block 60, #07-12 r/Can only attend on even weeks t/paid`

#### Adding a tuition class: `addclass`
Adds a tuition class with a set l/LIMIT of students at specified ts/TIMESLOT.

The students to be added are optional. If the student the user intends to add is not present, or the class limit has
been exceeded, TutAssistor will alert names of these students. The time slot should follow the
format "Www hh:mm-hh:mm" to help TutAssistor check if the time slot is already taken or there is an overlap
on time slots. If there is any conflict or overlap, TutAssistor will alert the conflict.

Format: `addclass n/NAME l/LIMIT ts/TIMESLOT [s/NAME,NAME,NAME...] [r/REMARK]`

Examples:
- `addclass n/Chemistry l/16 ts/Thu 15:00-17:00 s/Bernice Yu`
- `addclass n/Math l/8 ts/Mon 11:00-14:00 s/Richard Ng r/Quiz on final lesson`

### Viewing students/tuition classes
Provides a view of a student or class if an INDEX is provided. Otherwise, a full list is provided.

#### Viewing a student: `student`
Format: `student INDEX`

#### Viewing a tuition class: `class`
Format: `class INDEX`

### Editing students/tuition classes
Edits a student’s information such as n/NAME, p/PHONE_NUMBER.
Edits a tuition class at specified t/TIME.

#### Editing a student: `editstudent`
Format: `editstudent INDEX [n/NAME] [p/PHONE] [e/EMAIL] [a/ADDRESS] [t/TAG]…`

#### Editing a class: `editclass`
Format: `editclass INDEX l/limit t/time n/NAME,NAME,NAME... [t/TAG]…`


### Deleting students/tuition classes
Deletes a student or a tuition class given INDEX.

#### Deleting students: `delete`
Format: `delete STUDENT_INDEX STUDENT_INDEX`

Example:
- `delete 1 2`

#### Deleting tuition classes: `deleteclass`
Format: `deleteclass CLASS_INDEX CLASS_INDEX`

Example:
- `deletclass 1 2`

### Adding/Removing an existing student from class
Move a student to/from classes by adding or removing them.

#### Adding existing students to a class: `addtoclass`
Add one or more existing students to an existing class using student NAME or INDEX.
When the student to be added is already enrolled in the class or is not found in TutAssistor, TutAssistor will alert the
names of these students to the tutor.

When adding student names, using comma to separate names and there is no space around comma.
When adding student indexes, using space to separate indexes.

Format: `addtoclass si/INDEX_STUDENT INDEX_STUDENT INDEX_STUDENT... tc/INDEX_CLASS`
or `addtoclass s/NAME,NAME,NAME... tc/INDEX_CLASS`

Examples:
- `addtoclass si/1 tc/1`
- `addtoclass si/1 2 3 4 tc/1`
- `addtoclass s/James,Felicia tc/2`
- `addtoclass s/James tc/3`

#### Removing existing students from a class: `remove`
Removes existing students from a tuition class using student INDEX.

Format: `remove si/INDEX_STUDENT INDEX_STUDENT tc/INDEX_CLASS`

Examples:
- `remove si/1 tc/1`
- `remove si/1 2 3 4 tc/2`

### Adding remarks to a student: `remark`
Adds a remark to the identified student.

Format: `remark INDEX_STUDENT r/REMARK`

Examples:
- `remark 1 r/Haven't paid last week's fee`

#### Adding remarks to a tuition class: `remarkclass`
Format: `remarkclass INDEX_CLASS r/REMARK`

Examples:
- `remarkclass 2 r/Math homework due Friday`

### Finding students by name: `find`
Filters the list of students to only display all students whose names contain any of the given keywords (case-insensitive).

Format: `find NAME`

Example: `find alice tan`

TutAssitor will display a list of all students with 'alice' or 'tan' in their name.

#### Listing all students: `list`
Display list of all students after conducting a search with the `find` command.

Format: `list`

### Finding classes by name: `findclass`
Filters the list of classes to only display all classes whose names contain any of the given keywords (case-insensitive).

Format: `findclass NAME`

Example: `findclass physics chemistry`

TutAssitor will display a list of all classes with 'physics' or 'chemistry' in their name.

#### Listing all classes: `listclass`
Display list of all classes after conducting a search with the `find` command.

Format: `listclass`

### Sorting tuition classes: `sort`
Permanently sorts tuition class list according to time or alphabetical order.

If the tutor does not exit TutAssistor, the list will be auto-sorted
when adding and editing classes after the tutor sorted the list.

Format: `sort [o/ORDER]`

Examples: (examples below are all possible usages of `sort`)
- `sort` (without order being specified, TutAssistor will sort the list by time)
- `sort o/asc`
- `sort o/desc`
- `sort o/time`

### View timetable: `timetable`

Example:
- `timetable`
<br>

Shows lessons scheduled in this week in a timetable.<br>
![Ui](images/time_table.png)

### View today tuition classes: `today`
Shows all the tuition classes happens today

Format: `today`

### Viewing help: `help`
Shows a command summary and a link to the user guide. <br>
![Ui](images/helpWindow.png)

### Exiting the app: `exit`
Exits the program.<br>
Format: `exit`

## Command Summary

Action | Format
--------|------------------
***Add Student*** | `add n/NAME p/PHONE_NUMBER e/EMAIL a/ADDRESS [r/REMARK] [t/TAG]…`
***Add Class*** | `addclass l/limit t/time [s/NAME,NAME,NAME...] [r/REMARK] [t/TAG]…`
***View Student*** | `student INDEX`
***View Class*** | `class INDEX`
***Edit Student*** | `editstudent INDEX [n/NAME] [p/PHONE] [e/EMAIL] [a/ADDRESS]  [t/TAG]…`
***Edit Class*** | `editclass INDEX [n/NAME] [p/PHONE] [e/EMAIL] [a/ADDRESS] [t/TAG]…`
***Delete Student*** | `deletestudent INDEX_STUDENT INDEX_STUDENT`
***Delete Class*** | `deleteclass INDEX_CLASS INDEX_CLASS`
***Add Student to Class*** | `addtoclass si/INDEX_STUDENT INDEX_STUDENT tc/INDEX_CLASS` <br /> or `addtoclass s/NAME,NAME... tc/INDEX_CLASS`
***Remove Students from Class*** | `remove si/INDEX_STUDENT INDEX_STUDENT tc/INDEX_CLASS`
***Add Remarks to Student*** | `remark INDEX_STUDENT r/REMARK`
***Add Remarks to Class*** | `remarkclass INDEX_CLASS r/REMARK`
***Find Student by Name*** | `find NAME`
***List all Students*** | `list`
***Find Class by Name*** | `findclass NAME`
***List all Classes*** | `listclass`
***Sort Tuition Class*** | `sort [o/ORDER]`
***View Timetable*** | `timetable`
***View Today Classes*** | `today`
***Help*** | `help`
***Exit*** | `exit`


