import mult_slice_class, unittest

class TestFunString(unittest.TestCase):
	def setUp(self):
		self.test_string = mult_slice_class.FunString("Holy Grail")

	def test_multiply(self):
		self.assertEqual(self.test_string.multiply(3), "Holy GrailHoly GrailHoly Grail")

	def test_middle_three(self):
		self.assertEqual(self.test_string.middle_three(), "y G")

	def test_multiply_char_times(self):
		self.assertEqual(self.test_string.multiply_char_times(8, 7), "aaaaaaa")

	def test_multiply_range_times(self):
		self.assertEqual(self.test_string.multiply_range_times(2, 4, 4), "olyolyolyoly")
		