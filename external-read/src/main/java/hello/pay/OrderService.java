package hello.pay;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class OrderService {

    private final PayClient payClient;

    public void order(int money) {
        // 주문 로직
        payClient.pay(money);
    }
}
