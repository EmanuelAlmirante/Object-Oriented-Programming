# Object-Oriented Programming

This repository hosts the project of the course Object-Oriented Programming.

**Note:** This project is intended to only run using Eclipse IDE.

## Table of Contents

- [Objetives](https://github.com/EmanuelAlmirante/Object-Oriented-Programming/blob/master/README.md#objectives)
- [Structure and Funcionality of the Spreadsheet](https://github.com/EmanuelAlmirante/Object-Oriented-Programming/blob/master/README.md#structure-and-funcionality-of-the-spreadsheet)
  - [Addressing: Cells, Intervals, Ranges](https://github.com/EmanuelAlmirante/Object-Oriented-Programming/blob/master/README.md#addressing-cells-intervals-ranges)
  - [Content: Literals, References, Functions](https://github.com/EmanuelAlmirante/Object-Oriented-Programming/blob/master/README.md#content-literals-references-functions)
  - [Cell Operations](https://github.com/EmanuelAlmirante/Object-Oriented-Programming/blob/master/README.md#cell-operations)
  - [Searches](https://github.com/EmanuelAlmirante/Object-Oriented-Programming/blob/master/README.md#searches)
- [Flexibility and Efficiency Considerations](https://github.com/EmanuelAlmirante/Object-Oriented-Programming#flexibility-and-efficiency-considerations)
- [User Interaction](https://github.com/EmanuelAlmirante/Object-Oriented-Programming#user-interaction)
  - [Cell Addressing](https://github.com/EmanuelAlmirante/Object-Oriented-Programming#cell-addressing)
  - [Main menu](https://github.com/EmanuelAlmirante/Object-Oriented-Programming#main-menu)
    - [File Manipulation](https://github.com/EmanuelAlmirante/Object-Oriented-Programming#file-manipulation)
    - [Other Options](https://github.com/EmanuelAlmirante/Object-Oriented-Programming#other-options)
  - [Edit Menu](https://github.com/EmanuelAlmirante/Object-Oriented-Programming#main-menu)
    - [Visualize](https://github.com/EmanuelAlmirante/Object-Oriented-Programming#visualize)
    - [Insert](https://github.com/EmanuelAlmirante/Object-Oriented-Programming#insert)
    - [Copy](https://github.com/EmanuelAlmirante/Object-Oriented-Programming#copy)
    - [Delete](https://github.com/EmanuelAlmirante/Object-Oriented-Programming#delete)
    - [Cut](https://github.com/EmanuelAlmirante/Object-Oriented-Programming#cut)
    - [Paste](https://github.com/EmanuelAlmirante/Object-Oriented-Programming#paste)
    - [View cut buffer](https://github.com/EmanuelAlmirante/Object-Oriented-Programming#view-cut-buffer)
  - [Query Menu](https://github.com/EmanuelAlmirante/Object-Oriented-Programming#query-menu)
- [Initialization by Text Data File](https://github.com/EmanuelAlmirante/Object-Oriented-Programming#initialization-by-text-data-file) 
- [How To Compile](https://github.com/EmanuelAlmirante/Object-Oriented-Programming/blob/master/README.md#how-to-compile)
- [How To Test](https://github.com/EmanuelAlmirante/Object-Oriented-Programming/blob/master/README.md#how-to-test)

## Objectives

The objective of this project is to develop a spreadsheet, with  The interaction with the application is done using the terminal, where it is displayed all the options that are possible of being performed.

Any help or recommendation is welcome, so feel free to change the code.

## Structure and Funcionality of the Spreadsheet

### Addressing: Cells, Intervals, Ranges

The number of lines and columns of the sheet is fixed. The addresses (positions in the sheet: line and column) begin in 1.

A cell is defined based on it's position in the sheet: _CELL ::= LINE;COLUMN_. <br />
  **Example:** 1;2 (line 1, column 2), or 23;4 (line 23, column 4).
  
An interval (closed) is defined between two cells of the same line or column: _INTERVAL ::= CELL:CELL_. <br />
  **Example:** 1;2:1;20 (line 1, between the columns 2 and 20), or 23;4:57;4 (column 4, between the lines 23 and 57).
  
We use the term "range" to specificy indiscriminately an unique cell or a interval of cells.

### Content: Literals, References, Functions

### Cell Operations

### Searches

## Flexibility and Efficiency Considerations

## User Interaction

### Cell Addressing

### Main Menu

#### File Manipulation

#### Other Options

### Edit Menu

#### Visualize

#### Insert

#### Copy

#### Delete

#### Cut

#### Paste

#### View cut buffer

### Query Menu

## Initialization by Text Data File

## How To Compile

## How To Test

**UNDER CONSTRUCTION**
