# Change Log
All notable changes to this project will be documented in this file. This change log follows the conventions of [keepachangelog.com](http://keepachangelog.com/).

## [1.0.3] - 2021-10-22
### Fixed
- Updates Ecuador tax ID validation function. Tax IDs no longer comply with the check
digit algorithm.


## [1.0.2] - 2019-10-11
### Fixed
- Fixes a bug that caused an Exception to be raised instead of returning false. The bug
appeared when a non-numeric string was supplied as the identification number.


## [1.0.1] - 2019-07-22
### Fixed
- Fixes a bug in EC tax ID validation. A tax ID (RUC) that was previously ruled as a
state owned company, can be a personal ID too.


## [1.0.0] - 2018-03-09
### Added
- ClojureScript support.
- Constants for identification types.

### Fixed
- Fixes a length validation bug in Ecuadorean tax ID validation.


## [0.1.1] - 2018-01-25
### Fixed
- Fixes a bug that appeared when providing and unknown tax ID type.


## 0.1.0 - 2018-01-16
### Added
- Validation functions for Ecuadorean personal ID, public company ID and
private company ID.


[1.0.2]: https://github.com/datil/personas/compare/1.0.1...1.0.2
[1.0.1]: https://github.com/datil/personas/compare/1.0.0...1.0.1
[1.0.0]: https://github.com/datil/personas/compare/0.1.1...1.0.0
[0.1.1]: https://github.com/datil/personas/compare/0.1.0...0.1.1
