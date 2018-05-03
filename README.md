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

By omission, the cells are empty (without content). The admissible contents are: literals (integers), references, functions. References are indicated with the symbol "=" followed by the address of the referenced cell. The functions are indicated with the symbol "=", the name of the function and the list (possible empty) of arguments (separated by commas). The following functions are pre-defined:

  1. Binary functions, whose arguments can be references to cells or literal values: **ADD (addition)**, **SUB (subtraction)**, **MUL (multiplication)**, **DIV (division)**. <br />
    **Example:** ADD (2;3,1), SUB (6;2,22;1), MUL (1,2), DIV (1,5;2).
   
   2. Functions applied to an interval of cells: **AVG (average with integer division)**, **PRD (piatorio)**. <br />
    **Example:** AVG (1;2:1;19), PRD (2;33:5;33).
    
It is considered that there are no circular dependencies (direct or indirect), between functions and cells referenced by their arguments. The value to show for invalid references or functions with invalid arguments (reference empty cells), is _#VALUE_.

### Operations On Cells

It is possible to insert, delete and show contents. It is also possible to copy content between cells.

### Searches

It is possible to search the contents of the cells under different aspects: (i) values resulting from evaluation; (ii) names of functions.

## Flexibility and Efficiency Considerations

It should be possible to extend or change functionalities with minimal impact in the produced code: in particular, it should be simples to define new functions and new searches over the cells. The objective is to increase the flexibility of the application relatively to the support of new functions.

It should be possible to represent the structure of a spreadsheet using different approaches without impacting the remaning code of the application. The objective of this requisite is to allow the optimization of the occupied memory space to save the content of a spreadsheet. For example, in the case of spreadsheets of small dimensions you can have a structure that saves all cells regardeless of them being empty or not. This representation is inefficient for situations of spreadsheets of large dimensions and in which there are a great number of empty cells. The solution to develop does not need to materialize all situations (it just needs to materialize the first case) but should be sufficiently flexible to allow new representations.

A function depends of cells whose content can be changed at any moment. As a way to reduce the cost of execution of the application everytime a cell is changed, the number of times that which formula is calculated should be minimized. This requisit should only be considered after everything else is implemented. 

## User Interaction

Described below is the maximum functionality of the interface with the user. In general, the commands ask all the information before validating them (except where indicated). All the menus have the option _"Sair"_ (closes the menu).

The operations of reading and writing of data related with the interaction with the user must be performed through the objects _pt.utl.ist.po.ui.Form_ and _pt.utl.ist.po.ui.Display_, using the messages described (all the messages are produced through the calls to methods). A complete list of available classes can be obtained in the libraries pouilib and calc (support material). The interaction with the user, through operations of reading  or writing, should only be performed in the code related with the interface with the user (and never in the core of the application). It should not be defined any new messages.

The exceptions used in the interaction, except if indicated, are subclasses of _pt.utl.ist.po.ui.InvalidOperation_, are thrown by the commands and treated by _pt.utl.ist.po.ui.Menu_. Note that, besides the exceptions described, it is possible to define others. The new exceptions should not replace the ones given in the cases described in here.

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
