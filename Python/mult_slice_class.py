"""I've had this to do after one of Codewars Katas: practice making a class with string multiplication and splicing.
So here it is. Plus some tests to practice unittest/nose2.
"""
class FunString(str):
	def __init__(self, strng):
		self.strng = strng

	def multiply(self, times):
		return self.strng * times

	def middle_three(self):
		return self.strng[len(self.strng)//2-2:len(self.strng)//2+1]

	def multiply_char_times(self, char, times):
		"""Multiplies character number char (1-based) n-times."""
		return self.strng[char-1]*times

	def multiply_range_times(self, start, end, times):
		"""Multiplies range (1-based, inclusive of both ends) n-times."""
		return self.strng[start-1:end]*times
